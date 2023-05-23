package com.mbahjephthah.examgpt.features.settings_dialog.domain.model

data class UserData(
    val bookmarkedNewsResources: Set<String>,
    val followedTopics: Set<String>,
    val themeBrand: ThemeBrand,
    val darkThemeConfig: DarkThemeConfig,
    val useDynamicColor: Boolean,
    val shouldHideOnboarding: Boolean,
)

