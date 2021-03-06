import React from 'react'
import {Trans} from 'react-i18next'
import {FaTimes} from 'react-icons/fa'
import {Alert, Button} from 'reactstrap'

const FeedbackMessage = ({className = 'mb-0', message, onClose}) => {
  let {color = 'info', key, links = [], values} = message
  links = links.map((link) => (
    <a
      href={link}
      key={link}
      style={{color: 'inherit', textDecoration: 'underline'}}
    ></a>
  ))
  return (
    <Alert className={className} color={color}>
      <Trans components={links} i18nKey={`feedback:${key}`} values={values} />
      {onClose && (
        <Button
          className="close"
          color="link"
          onClick={onClose}
          style={{color: 'inherit'}}
        >
          <FaTimes size={16} />
        </Button>
      )}
    </Alert>
  )
}

export default FeedbackMessage
