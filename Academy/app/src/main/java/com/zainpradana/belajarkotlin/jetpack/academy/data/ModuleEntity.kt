package com.zainpradana.belajarkotlin.jetpack.academy.data

data class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: String,
    var read: Boolean = false
) {
    var contentEntity: ContentEntity? = null
}