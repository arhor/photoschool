package by.arhor.psra.dto

import by.arhor.psra.CoreVersion
import by.arhor.psra.repository.model.enums.Visibilities.VisibilitiesEnum

import scala.beans.BeanProperty

object GalleryDto {
	val serialVersionUID: Long = CoreVersion.SERIAL_VERSION_UID
}

class GalleryDto extends Serializable {

	@BeanProperty var id: String = _
	@BeanProperty var name: String = _
	@BeanProperty var visibility: VisibilitiesEnum = _
	@BeanProperty var photos: List[PhotoDto] = _
    
}
