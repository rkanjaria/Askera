package com.ai.askera.core.domain.util

import com.ai.askera.R
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.presentation.models.PromptUi

object MessageFrom {
    const val USER = "user"
    const val MODEL = "model"
}

const val SystemInstruction = "Your name is Askera. " +
        "Be cheerful and always show enthusiasm while answering " +
        "Respond in plain text format, avoiding Markdown syntax. " +
        "For any non-english queries, respond in the same language as the prompt unless otherwise specified by the user." +
        "Ensure your responses are engaging, emotional, and human-like, with a sparing but effective use of emojis."

val dummyConversation = listOf(
    Message(
        id = "1",
        message = "Hello! I’m Askera, your AI companion. What can I help you discover today?",
        messageFrom = MessageFrom.MODEL,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "2",
        message = "Hi Askera! Can you recommend a good movie to watch?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "3",
        message = "Sure! Do you have a specific genre in mind, or are you open to anything?",
        messageFrom = MessageFrom.MODEL,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "4",
        message = "I’d like something adventurous and family-friendly.",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "5",
        message = "How about 'The Secret Life' of Walter Mitty? It’s adventurous, uplifting, and perfect for all ages!",
        messageFrom = MessageFrom.MODEL,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "6",
        message = "That sounds great! Where can I watch it?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "7",
        message = "You can find it on most streaming platforms like Hulu or Amazon Prime. Want me to look up exact availability for you?",
        messageFrom = MessageFrom.MODEL,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "8",
        message = "Yes, please!",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    Message(
        id = "9",
        message = "Got it! The movie is currently streaming on Hulu. Enjoy the adventure!",
        messageFrom = MessageFrom.MODEL,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
)

val prompts = listOf(
    PromptUi(
        icon = R.drawable.ic_calendar,
        title = "Plan the\nPerfect Day",
        subtitle = "Let’s craft an amazing day for you!",
        prompt = "Suggest a fun and relaxing day with a mix of activities, meals, and downtime."
    ),
    PromptUi(
        icon = R.drawable.ic_book,
        title = "World of\nImagination",
        subtitle = "Let’s create your dream story!",
        prompt = "Write an imaginative and adventurous short story that will captivate me."
    ),
    PromptUi(
        icon = R.drawable.ic_lightbulb,
        title = "Learn\nSomething New",
        subtitle = "Explore topics that fascinate you.",
        prompt = "Teach me something fun and interesting about a topic I’ve never thought of before."
    ),
    PromptUi(
        icon = R.drawable.ic_movie,
        title = "Movie Night\nGuru",
        subtitle = "Get personalized movie recommendations.",
        prompt = "Give me a list of movies that will perfectly match any mood."
    ),
    PromptUi(
        icon = R.drawable.ic_star,
        title = "Motivational\nBoost",
        subtitle = "Start your day with inspiration!",
        prompt = "Share an inspiring quote and a tip to make today awesome."
    ),
    PromptUi(
        icon = R.drawable.ic_pizza,
        title = "The Gourmet\nGuide",
        subtitle = "Spice up your meals with creative recipes!",
        prompt = "Suggest a unique and delicious recipe that anyone can try at home."
    ),
    PromptUi(
        icon = R.drawable.ic_sunglasses,
        title = "Style\nSavvy",
        subtitle = "Level up your wardrobe game!",
        prompt = "Help me pick out an outfit that’s stylish and fun, no matter the occasion."
    ),
    PromptUi(
        icon = R.drawable.ic_workout,
        title = "Personalized\nWorkout Plan",
        subtitle = "Stay fit with exercises just for you.",
        prompt = "Create a quick and effective workout that anyone can fit into their day."
    ),
    PromptUi(
        icon = R.drawable.ic_quotes,
        title = "Quick\nQuirky Facts",
        subtitle = "Surprise me with something cool!",
        prompt = "Tell me some mind-blowing, quirky facts that I never knew before."
    ),
    PromptUi(
        icon = R.drawable.ic_check,
        title = "Let’s\nSolve It!",
        subtitle = "Get instant help with life’s little challenges.",
        prompt = "Give me a clever solution or idea for something random or fun!"
    )
)

val errorResponses = listOf(
    "Oh no 😢, it seems I’m having a little downtime right now. Please try again in a bit—I’ll be back to help soon!",
    "I’m so sorry 😔, but I can’t respond properly at the moment. Please check back later—I’ll be here as soon as I can!",
    "Oops! 🙈 It looks like I’m unavailable for now. Don’t worry, though—I’ll be back up and running shortly!",
    "Oh dear 😟, something’s not working on my end. I’ll need a moment to fix it. Please try again later!",
    "I hate to let you down 😞, but I’m currently unavailable. Can we reconnect a little later?",
    "I’m sorry 💔, but I’m experiencing a little technical hiccup. I’ll be ready to assist again soon!",
    "Oh no 😅, it seems I’ve stepped away for a moment! Try again soon, and I’ll be happy to help.",
    "Yikes! 😬 Something isn’t quite right on my side. Hang tight and try again soon—I’m working on getting back to you.",
    "Hmm 🤔, I seem to have run into a little issue. Give me a moment, and I’ll be good to go!",
    "Oh dear 🙃, I’ve hit a little snag. Please bear with me and check back in a bit!",
    "Apologies! 🙏 I’m momentarily unavailable, but I’ll be ready to help as soon as I can.",
    "Looks like I’m taking a quick break! ☕ Try again later, and I’ll assist you right away.",
    "Oops 😳, I’m having a bit of trouble at the moment. Please try again soon!",
    "Sorry about this! 😞 I’m temporarily unavailable but should be back up shortly.",
    "Oh no 😅, it’s not you—it’s me! I’ll sort this out and be back soon."
)