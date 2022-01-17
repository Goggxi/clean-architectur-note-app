package com.goggxi.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.goggxi.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.goggxi.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.goggxi.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import java.lang.Exception

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title is required")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("Content is required")
        }

        repository.insertNote(note)
    }

}