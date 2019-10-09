import React from 'react';
import {
  Col,
  Form,
  Nav,
  Row,
  TabContent
} from 'reactstrap';
import { useTranslation } from 'react-i18next';

import FormEditor from './FormEditor';
import FormIdInput from './FormIdInput';
import FormButtons from './FormButtons';
import LanguageAdder from './LanguageAdder';
import LanguageTab from './LanguageTab';
import LanguageTabContent from './LanguageTabContent';

const WebpageForm = (props) => {
  const { t } = useTranslation();
  return (
    <Form onSubmit={evt => {
      evt.preventDefault();
      props.onSubmit();
    }}>
      <Row>
        <Col xs='6' sm='9'>
          <h1>
            {props.identifiable.uuid ? t('editWebpage') : t('createWebpage')}
          </h1>
        </Col>
        <Col xs='6' sm='3'>
          <FormButtons />
        </Col>
      </Row>
      <Row>
        <Col sm='12'>
          <hr />
        </Col>
      </Row>
      <Row>
        <Col sm='12'>
          {props.identifiable.uuid && <FormIdInput id={props.identifiable.uuid} />}
          <Nav tabs>
            {Object.entries(props.identifiable.label).map(([language]) => <LanguageTab
              activeLanguage={props.activeLanguage}
              key={language}
              language={language}
              onClick={(language => props.onToggleLanguage(language))}
            />)}
            {props.canAddLanguage && <LanguageAdder onClick={props.onAddLanguage} />}
          </Nav>
          <TabContent activeTab={props.activeLanguage}>
            {Object.entries(props.identifiable.label).map(([language, text]) => <LanguageTabContent
              description={props.identifiable.description[language]}
              key={language}
              label={text}
              language={language}
              onUpdate={(updateKey, updateValue) => props.onUpdate({
                ...props.identifiable,
                [updateKey]: {
                  ...props.identifiable[updateKey],
                  [language]: updateValue
                }
              })}
            >
              <FormEditor
                document={props.identifiable.text[language]}
                type='text'
                onUpdate={document => {
                  props.onUpdate({
                    ...props.identifiable,
                    'text': {
                      ...props.identifiable['text'],
                      [language]: document
                    }
                  })
                }}
              />
            </LanguageTabContent>)}
          </TabContent>
        </Col>
      </Row>
    </Form>
  )
};

export default WebpageForm;