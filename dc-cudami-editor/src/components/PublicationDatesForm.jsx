import React from 'react'
import {Col, FormGroup, Label, Row} from 'reactstrap'
import DatePicker from 'react-date-picker'
import {useTranslation} from 'react-i18next'

const PublicationDatesForm = ({
  onChange,
  publicationEndDate,
  publicationStartDate,
}) => {
  const {t} = useTranslation()

  const formatDate = (date) => {
    if (date) {
      // Selected datetime will be displayed correctly in DatePicker.
      // But after reloading, there's a minus one-day offset. Here
      // we add 12 hours (could be related to the time zone of the user)
      // to the user-defined date to workaround this issue 😒
      date.setHours(date.getHours() + 12)
      return date.toISOString().slice(0, 10)
    }
    return undefined
  }

  return (
    <FormGroup>
      <Row>
        <Col>
          <Label className="font-weight-bold" for="publication-start-date">
            {t('startPublicationDate')}:
          </Label>
        </Col>
        <Col>
          <DatePicker
            calendarAriaLabel={t('datePicker.toggleCalendar')}
            clearAriaLabel={t('datePicker.clearDate')}
            dayAriaLabel={t('datePicker.day')}
            id={'publication-start-date'}
            monthAriaLabel={t('datePicker.month')}
            nativeInputAriaLabel={t('datePicker.date')}
            onChange={(date) => onChange('publicationStart', formatDate(date))}
            required={false}
            value={publicationStartDate && new Date(publicationStartDate)}
            yearAriaLabel={t('datePicker.year')}
          />
        </Col>
        <Col>
          <Label className="font-weight-bold" for="publication-end-date">
            {t('endPublicationDate')}:
          </Label>
        </Col>
        <Col>
          <DatePicker
            calendarAriaLabel={t('datePicker.toggleCalendar')}
            clearAriaLabel={t('datePicker.clearDate')}
            dayAriaLabel={t('datePicker.day')}
            id={'publication-end-date'}
            monthAriaLabel={t('datePicker.month')}
            nativeInputAriaLabel={t('datePicker.date')}
            onChange={(date) => onChange('publicationEnd', formatDate(date))}
            required={false}
            value={publicationEndDate && new Date(publicationEndDate)}
            yearAriaLabel={t('datePicker.year')}
          />
        </Col>
      </Row>
    </FormGroup>
  )
}

export default PublicationDatesForm