package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    init{
        fetchCharacters()
    }

    private fun fetchCharacters(){
        viewModelScope.launch{
            try{
                val response = RetrofitClient.api.getCharacters()
                _characters.value = response.results
                response.results.forEach{
                    Log.d("CHARATER", "${it.name} ( ${it.species} ) ( ${it.status} )")
                }

            } catch (e: Exception){
                Log.e("CHARACTER", "Error: ${e.message}")
            }

        }
    }



}