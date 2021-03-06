export function formatDate(date, locale, onlyDate = false) {
  const options = {
    day: '2-digit',
    hour12: false,
    month: '2-digit',
    year: 'numeric',
  }
  if (onlyDate) {
    return date?.toLocaleDateString(locale, options)
  }
  return date?.toLocaleString(locale, {
    ...options,
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
  })
}

export function getImageUrl(image, width = 'full') {
  if (!image.httpBaseUrl || !image.mimeType) {
    return image.uri
  }
  const mimeExtensionMapping = {
    gif: 'gif',
    png: 'png',
  }
  const subMimeType = image.mimeType.split('/')[1]
  return `${image.httpBaseUrl}/full/${width}/0/default.${
    mimeExtensionMapping[subMimeType] ?? 'jpg'
  }`
}

export function getVideoUrl(video) {
  if (!video.httpBaseUrl || !video.mimeType) {
    return video.uri
  }
  return `${video.httpBaseUrl}/default.mp4`
}
