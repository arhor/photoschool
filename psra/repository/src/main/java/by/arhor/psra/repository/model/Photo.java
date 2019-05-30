package by.arhor.psra.repository.model;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import by.arhor.psra.CoreVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents photo file.
 * 
 * @author Maksim Buryshynets
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"comments"})
@ToString(exclude = {"comments"})
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "photos")
public class Photo extends IdentifiedEntity {
	
	private static final long serialVersionUID = CoreVersion.SERIAL_VERSION_UID;
	
	@Field("path")
    private String path;
	
	@Field("name")
    private String name;
	
	@Field("description")
    private String description;
	
	@Field("tags")
	private Set<Tag> tags;
	
	@Field("comments")
	private List<Comment> comments;
	
	@Override
	public Photo clone() {
		var clone = new Photo();
		
		clone.id = this.id;
		clone.dateTimeCreated = this.dateTimeCreated;
		clone.dateTimeUpdated = this.dateTimeUpdated;
		clone.enabled = this.enabled;
		
		clone.path = this.path;
		clone.name = this.name;
		clone.description = this.description;
		clone.tags = this.tags != null
				? this.tags.stream().map(Tag::clone).collect(toSet())
				: null;
		clone.comments = this.comments != null
				? this.comments.stream().map(Comment::clone).collect(toList())
				: null;
				
		return clone;
	}
    
}
