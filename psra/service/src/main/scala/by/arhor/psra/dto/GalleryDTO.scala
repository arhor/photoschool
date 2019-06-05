package by.arhor.psra.dto

import java.time.LocalDateTime

import scala.beans.BeanProperty

class GalleryDTO {

  @BeanProperty var id: String = _
  @BeanProperty var dateTimeCreated: LocalDateTime = _
  @BeanProperty var dateTimeUpdated: LocalDateTime = _
  @BeanProperty var enabled: Boolean = true

}
