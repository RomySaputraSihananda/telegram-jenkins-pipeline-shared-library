package com.romy.telegram

class Telegram {
    String botToken
    String chatId
    String messageThreadId

    Telegram(String botToken, String chatId, String messageThreadId) {
        this.botToken = botToken
        this.chatId = chatId
        this.messageThreadId = messageThreadId
    }

    def sendMessage(String message, String parseMode = "MarkDown") {
        sh """
        curl -X POST https://api.telegram.org/bot${this.botToken}/sendMessage \
        -H "Content-Type: application/json" \
        -d '{"chat_id": "${this.chatId}", "message_thread_id": "${this.messageThreadId}", "text": "${message}", "disable_notification": true, "parse_mode":"${parseMode}"}'
        """
    }
}
