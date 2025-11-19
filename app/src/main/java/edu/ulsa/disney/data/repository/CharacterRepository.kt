package edu.ulsa.disney.repository

import edu.ulsa.disney.data.remote.RetrofitClient

class CharacterRepository {

    private val api = RetrofitClient.api

    suspend fun getCharacters() = api.getCharacters().results

    suspend fun getCharacterDetail(id: Int) = api.getCharacterDetail(id)
}
