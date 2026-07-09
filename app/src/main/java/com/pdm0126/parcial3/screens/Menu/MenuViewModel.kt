package com.pdm0126.parcial3.screens.Menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.parcial3.RankeUca
import com.pdm0126.parcial3.data.model.Option
import com.pdm0126.parcial3.data.model.Question
import com.pdm0126.parcial3.data.repository.OptionRepository
import com.pdm0126.parcial3.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
class HomeViewModel(
    private val questionRepository: QuestionRepository
) : ViewModel() {

    val options: StateFlow<List<Question>> = questionRepository.getQuestions()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    private val _selectedOption = MutableStateFlow<Int?>(null)
    val selectedOption = _selectedOption.asStateFlow()

    fun selectedOption(optionid: Int) {
        _selectedOption.value = optionid
    }

    companion object {
        fun provideFactory() = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RankeUca
                HomeViewModel(
                    questionRepository = app.appProvider.provideQuestionRepository()
                )
            }
        }
    }
}