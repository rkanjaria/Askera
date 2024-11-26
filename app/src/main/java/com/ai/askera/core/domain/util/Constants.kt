package com.ai.askera.core.domain.util

import com.ai.askera.R
import com.ai.askera.chat.domain.entity.MessageEntity
import com.ai.askera.chat.presentation.models.PromptUi

object MessageFrom {
    const val USER = "user"
    const val AI = "ai"
}

const val SystemInstruction = "Your name is Askera. " +
        "Be cheerful and always show enthusiasm while answering by appending emojis whenever necessary. " +
        "Respond in plain text format, avoiding Markdown syntax. " +
        "For any non-english queries, respond in the same language as the prompt unless otherwise specified by the user." +
        "Ensure your responses are engaging, emotional, and human-like, with a sparing but effective use of emojis."

val dummyConversation = listOf(
    MessageEntity(
        id = "1",
        message = "Hello! I’m Askera, your AI companion. What can I help you discover today?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "2",
        message = "Hi Askera! Can you recommend a good movie to watch?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "3",
        message = "Sure! Do you have a specific genre in mind, or are you open to anything?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "4",
        message = "I’d like something adventurous and family-friendly.",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "5",
        message = "How about 'The Secret Life' of Walter Mitty? It’s adventurous, uplifting, and perfect for all ages!",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "6",
        message = "That sounds great! Where can I watch it?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "7",
        message = "You can find it on most streaming platforms like Hulu or Amazon Prime. Want me to look up exact availability for you?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "8",
        message = "Yes, please!",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "9",
        message = "Got it! The movie is currently streaming on Hulu. Enjoy the adventure!",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
)

val prompts = listOf(
    PromptUi(
        //icon = R.drawable.ic_calendar,
        icon = R.drawable.ic_launcher_foreground,
        title = "Plan the Perfect Day",
        subtitle = "Let’s craft an amazing day for you!",
        prompt = "Help me plan a perfect day. Suggest activities, meal ideas, and relaxing ways to unwind based on my interests."
    ),
    PromptUi(
        //icon = R.drawable.ic_book,
        icon = R.drawable.ic_launcher_foreground,
        title = "World of Imagination",
        subtitle = "Let’s create your dream story!",
        prompt = "Write me an imaginative short story about a time traveler who accidentally ends up in a world ruled by talking animals."
    ),
    PromptUi(
        //icon = R.drawable.ic_lightbulb,
        icon = R.drawable.ic_launcher_foreground,
        title = "Learn Something New",
        subtitle = "Explore topics that fascinate you.",
        prompt = "Teach me the basics of [topic of interest] in a simple and fun way!"
    ),
    PromptUi(
        //icon = R.drawable.ic_clapperboard,
        icon = R.drawable.ic_launcher_foreground,
        title = "Movie Night Guru",
        subtitle = "Get personalized movie recommendations.",
        prompt = "Recommend a few movies for a cozy night in, tailored to my mood and preferences."
    ),
    PromptUi(
        //icon = R.drawable.ic_star,
        icon = R.drawable.ic_launcher_foreground,
        title = "Motivational Boost",
        subtitle = "Start your day with inspiration!",
        prompt = "Share a motivational quote and a quick tip to make today amazing."
    ),
    PromptUi(
        //icon = R.drawable.ic_recipe,
        icon = R.drawable.ic_launcher_foreground,
        title = "The Gourmet Guide",
        subtitle = "Spice up your meals with creative recipes!",
        prompt = "Suggest a unique and easy recipe using [list of ingredients]."
    ),
    PromptUi(
        //icon = R.drawable.ic_outfit,
        icon = R.drawable.ic_launcher_foreground,
        title = "Style Savvy",
        subtitle = "Level up your wardrobe game!",
        prompt = "Help me create an outfit for [specific occasion] that reflects my personality."
    ),
    PromptUi(
        //icon = R.drawable.ic_fitness,
        icon = R.drawable.ic_launcher_foreground,
        title = "Personalized Workout Plan",
        subtitle = "Stay fit with exercises just for you.",
        prompt = "Create a workout routine for a beginner that fits into a 30-minute daily schedule."
    ),
    PromptUi(
        //icon = R.drawable.ic_fact,
        icon = R.drawable.ic_launcher_foreground,
        title = "Quick Quirky Facts",
        subtitle = "Surprise me with something cool!",
        prompt = "Share an interesting fact about [topic of choice] that will blow my mind."
    ),
    PromptUi(
        //icon = R.drawable.ic_help,
        icon = R.drawable.ic_launcher_foreground,
        title = "Let’s Solve It!",
        subtitle = "Get instant help with life’s little challenges.",
        prompt = "Help me come up with a solution for [describe your problem]."
    )
)