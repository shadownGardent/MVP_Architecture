package com.example.mvp_architecture.model

object Utils {
    fun fakeData() : List<User> {
        return listOf(
            User(1, "admin", "admin@123", "Admin", "Shadow Garden", "test@gmail.com"),
            User(2, "admin1", "admin1@123", "Admin1", "Shadow Garden", "test1@gmail.com"),
            User(3, "admin2", "admin2@123", "Admin2", "Shadow Garden", "test2@gmail.com")
        )
    }
}