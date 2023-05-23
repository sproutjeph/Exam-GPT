package com.mbahjephthah.examgpt.features.settings_dialog.data.repository

import com.mbahjephthah.examgpt.features.settings_dialog.domain.model.DarkThemeConfig
import com.mbahjephthah.examgpt.features.settings_dialog.domain.model.ThemeBrand
import com.mbahjephthah.examgpt.features.settings_dialog.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    /**
     * Stream of [UserData]
     */
    val userData: Flow<UserData>

    /**
     * Sets the user's currently followed topics
     */
    suspend fun setFollowedTopicIds(followedTopicIds: Set<String>)

    /**
     * Toggles the user's newly followed/unfollowed topic
     */
    suspend fun toggleFollowedTopicId(followedTopicId: String, followed: Boolean)

    /**
     * Updates the bookmarked status for a news resource
     */
    suspend fun updateNewsResourceBookmark(newsResourceId: String, bookmarked: Boolean)

    /**
     * Sets the desired theme brand.
     */
    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    /**
     * Sets the desired dark theme config.
     */
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

    /**
     * Sets the preferred dynamic color config.
     */
    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)

    /**
     * Sets whether the user has completed the onboarding process.
     */
    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}
