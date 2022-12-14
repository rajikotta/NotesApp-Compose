package com.raji.notesapp.di

import android.app.Application
import androidx.room.Room
import com.raji.notesapp.feature_note.data.local.NoteDataBase
import com.raji.notesapp.feature_note.data.repository.NoteRepositoryImpl
import com.raji.notesapp.feature_note.domain.repositories.NoteRepository
import com.raji.notesapp.feature_note.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): NoteDataBase {
        return Room.databaseBuilder(
                application, NoteDataBase::class.java, "notes_db"
        ).build()

    }

    @Singleton
    @Provides
    fun provideNoteRepsitory(dataBase: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(dataBase.dao)
    }

    @Singleton
    @Provides
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
                getNoteUseCase = GetNoteUseCase(repository),
                deleteNote = DeleteNoteUsecase(repository),
                addNoteUsecase = AddNoteUsecase(repository),
                getNoteDetailsUsecase = GetNoteDetailsUsecase(repository)
        )
    }
}