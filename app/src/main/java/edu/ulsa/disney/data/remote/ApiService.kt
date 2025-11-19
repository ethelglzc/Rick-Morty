package edu.ulsa.disney.data.remote

import edu.ulsa.disney.data.model.Character
import edu.ulsa.disney.data.model.CharacterDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): CharacterDetail
}

data class CharacterResponse(
    val results: List<Character>
)
