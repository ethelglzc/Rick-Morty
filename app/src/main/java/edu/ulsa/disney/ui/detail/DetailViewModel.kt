package edu.ulsa.disney.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ulsa.disney.data.model.CharacterDetail
import edu.ulsa.disney.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repo = CharacterRepository()

    private val _detail = MutableStateFlow<CharacterDetail?>(null)
    val detail: StateFlow<CharacterDetail?> = _detail

    fun loadCharacterDetail(id: Int) {
        viewModelScope.launch {
            _detail.value = repo.getCharacterDetail(id)
        }
    }
}
