package com.joshuacerdenia.android.easynotepad.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var category: String = "",
    var title: String = "",
    var dateCreated: Date = Date(),
    var lastModified: Date = Date(),
    var body: String = ""
) {

    fun isEmpty(): Boolean {
        return category.isEmpty() && title.isEmpty() && body.isEmpty()
    }

    fun toMinimal(): NoteMinimal {
        return NoteMinimal(id, category, title, lastModified)
    }

    fun update(category: String, title: String, body: String, lastModified: Date = Date()) {
        this.category = category
        this.title = title
        this.body = body
        this.lastModified = lastModified
    }

    fun isContentChanged(category: String, title: String, body: String): Boolean {
        return this.category != category || this.title != title || this.body != body
    }

    // For testing only; delete later.
    fun dummy() {
        title = listOf(
            "This is a note",
            "This is another note",
            "Obviously a note",
            "Notes on nothing",
            "Here's a note"
        ).shuffled().first()
        category = listOf(
            "English",
            "Thoughts",
            "Nothings",
            "Science",
            "Philosophy"
        ).shuffled().first()
    }
}