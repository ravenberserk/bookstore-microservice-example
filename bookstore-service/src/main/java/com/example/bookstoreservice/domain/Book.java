package com.example.bookstoreservice.domain;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection="books")
public class Book {
	
	@Id
	private String _id;
	
	@NotNull
	private String title;
	
	@NotNull
	private String summary;

	public Book(@NotNull String title, @NotNull String summary) {
		super();
		this.title = title;
		this.summary = summary;
	}
	
}
