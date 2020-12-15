package com.example.familytree

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.Reader

data class Person(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("adulthood")
    val adulthood: Boolean,
    @SerializedName("relatives")
    val relatives: Int,
    @SerializedName("mother")
    val mother: Person,
    @SerializedName("father")
    val father: Person
)

fun main() {

    // read file /res/raw/familytree.json
    var reader: Reader =
        File(System.getProperty("user.dir") + "/app/src/main/res/raw/familytree.json").reader()

    val gson = Gson()

    //Deserialize
    val person = gson.fromJson(reader, Person::class.java)

    println(person)

    // Serialize
    println(gson.toJson(person))

}