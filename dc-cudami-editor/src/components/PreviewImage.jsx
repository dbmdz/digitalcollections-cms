import React, {useContext} from 'react'

import AppContext from './AppContext'
import {getImageUrl} from './utils'

const PreviewImage = ({
  className = 'mb-0 mx-auto',
  image,
  language,
  renderingHints = {},
  showCaption = false,
  width,
}) => {
  const {apiContextPath, defaultLanguage} = useContext(AppContext)
  if (!language) {
    language = defaultLanguage
  }
  const {altText, caption, title} = renderingHints
  return (
    <figure className={className} style={{maxWidth: `${width}px`}}>
      <img
        alt={altText?.[language] ?? ''}
        className="img-fluid mw-100"
        src={
          image
            ? getImageUrl(image, `${width},`)
            : `${apiContextPath}images/no-image.png`
        }
        title={title?.[language]}
      />
      {showCaption && caption?.[language] && (
        <figcaption className="figure-caption">{caption[language]}</figcaption>
      )}
    </figure>
  )
}

export default PreviewImage
