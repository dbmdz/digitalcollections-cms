(function(prosemirrorState, prosemirrorView, prosemirrorModel, prosemirrorSchemaBasic, prosemirrorSchemaList, prosemirrorExampleSetup, proseMirrorMenu){
  'use strict';

  var iframeNodeSpec = {
    attrs: {
      height: {},
      src: {},
      width: {}
    },
    draggable: true,
    group: 'block',
    inline: false,
    parseDOM: [{
      tag: 'iframe[src]',
      getAttrs: function(element){
        return {
          'height': element.getAttribute('height'),
          'src': element.getAttribute('src'),
          'width': element.getAttribute('width')
        };
      }
    }],
    toDOM: function(node){
      return ['iframe', {
        'class': 'editable',
        'height': node.attrs.height,
        'sandbox': '',
        'src': node.attrs.src,
        'width': node.attrs.width,
      }];
    }
  };

  // Mix the nodes from prosemirror-schema-list into the basic schema to
  // create a schema with list support.
  var schema = new prosemirrorModel.Schema({
    nodes: prosemirrorSchemaList.addListNodes(
      prosemirrorSchemaBasic.schema.spec.nodes, 'paragraph block*', 'block'
    ).addBefore('image', 'iframe', iframeNodeSpec),
    marks: prosemirrorSchemaBasic.schema.spec.marks
  });

  var iframeDialogTemplate = [
    '<div id="iframe-dialog" class="modal fade" tabindex="-1" role="dialog">',
    '<div class="modal-dialog" role="document">',
    '<div class="modal-content">',
    '<div class="modal-header">',
    '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>',
    '<h4 class="modal-title">Insert iframe</h4>',
    '</div>',
    '<div class="modal-body">',
    '<form>',
    '<div class="form-group">',
    '<input class="form-control" id="iframe-src" placeholder="src" required type="text">',
    '</div>',
    '<div class="form-group">',
    '<input class="form-control" id="iframe-width" placeholder="width" type="text">',
    '</div>',
    '<div class="form-group">',
    '<input class="form-control" id="iframe-height" placeholder="height" type="text">',
    '</div>',
    '<button class="btn btn-primary" id="save" type="submit">Save</button>',
    '</form>',
    '</div>',
    '</div>',
    '</div>',
    '</div>'
  ].join('');

  function canInsertIframe(state, nodeType){
    var $from = state.selection.$from;
    for(var d = $from.depth; d >= 0; d--){
      var index = $from.index(d);
      if($from.node(d).canReplaceWith(index, index, nodeType)){
        return true;
      }
    }
    return false;
  }

  var openIframeDialog = function(state, view, nodeType){
    $(document.body).append(iframeDialogTemplate);
    if(state.selection instanceof prosemirrorState.NodeSelection && state.selection.node.type === nodeType){
      var attrs = state.selection.node.attrs;
      $('#iframe-dialog #iframe-height').val(attrs.height);
      $('#iframe-dialog #iframe-src').val(attrs.src);
      $('#iframe-dialog #iframe-width').val(attrs.width);
    }
    $('#iframe-dialog form').submit(function(evt){
      evt.preventDefault();
      view.dispatch(view.state.tr.replaceSelectionWith(nodeType.createAndFill({
        'height': $(this).find('#iframe-height').val(),
        'src': $(this).find('#iframe-src').val(),
        'width': $(this).find('#iframe-width').val()
      })));
      view.focus();
      $(this).closest('#iframe-dialog').modal('hide');
    });
    $('#iframe-dialog').on('hidden.bs.modal', function(){
      $(this).remove();
    });
    $('#iframe-dialog').modal('show');
  };

  var menu = prosemirrorExampleSetup.buildMenuItems(schema);
  menu.insertMenu.content.push(new proseMirrorMenu.MenuItem({
    title: 'Insert iframe',
    label: 'Iframe',
    enable: function(state){ return canInsertIframe(state, schema.nodes.iframe); },
    run: function(state, _, view){ openIframeDialog(state, view, schema.nodes.iframe); }
  }));

  var contents = $('.content');
  var editorViews = {};
  contents.each(function(i, contentElement){
    var contentJson = JSON.parse($(this).val());
    $.each(contentJson.localizedStructuredContent, function(language, content){
      var currentEditor = document.querySelector(
        '.editor[data-content-id=' + contentElement.id + ']' +
        '[data-content-language=' + language + ']'
      );
      var editorView = new prosemirrorView.EditorView(currentEditor, {
        state: prosemirrorState.EditorState.create({
          // from HTML:
          // doc: prosemirrorModel.DOMParser.fromSchema(mySchema).parse(document.querySelector('#content')),

          // from JSON:
          doc: prosemirrorModel.Node.fromJSON(schema, content),
          plugins: prosemirrorExampleSetup.exampleSetup({schema: schema, menuContent: menu.fullMenu})
        }),
        dispatchTransaction: function(tr){
          var currentEditorView = editorViews[this.contentElement.id + '+' + language];
          currentEditorView.updateState(currentEditorView.state.apply(tr));
          // current state as json in text area
          this.contentJson.localizedStructuredContent[this.language] = currentEditorView.state.doc.toJSON();
          $(this.contentElement).val(JSON.stringify(this.contentJson));
        }.bind({
          'contentElement': contentElement, 'contentJson': contentJson, 'language': language
        })
      });
      editorViews[contentElement.id + '+' + language] = editorView;
    });
  });
}(PM.state, PM.view, PM.model, PM.schema_basic, PM.schema_list, PM.example_setup, PM.menu));