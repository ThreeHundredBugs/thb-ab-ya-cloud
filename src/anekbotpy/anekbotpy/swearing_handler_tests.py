from unittest.mock import AsyncMock

import pytest

from .swearing_handler import handle_swearing

message_event_tpl = {
    "update_id": 1,
    "message": {
        "message_id": 2,
        "from": {
            "id": 3,
            "is_bot": False,
            "first_name": "Dmitry",
            "username": "Koshka",
            "language_code": "ru"
        },
        "chat": {
            "id": -4,
            "title": "____ бык",
            "type": "supergroup"
        },
        "date": 1688401542,
        "text": "Анек!дот"
    }
}


@pytest.mark.asyncio
@pytest.mark.parametrize('text', [
    'застрахуй меня',
    'привет',
    'Клавиши низко посажены',
    'Анек!дот',
])
async def test_handle_swearing_negative(text: str) -> None:
    bot = AsyncMock()
    event = message_event_tpl.copy()
    event['message']['text'] = text

    await handle_swearing(bot, event)

    bot.send_message.assert_not_called()


@pytest.mark.asyncio
@pytest.mark.parametrize('text', [
    'что эта пизда себе позволяет?',
    'ёбнул бы ему',
    'нам всем пиздец!',
    'тебя давно пиздили?',
    'здарова, заебал',
])
async def test_handle_swearing_positive(text: str) -> None:
    bot = AsyncMock()
    event = message_event_tpl.copy()
    event['message']['text'] = text

    await handle_swearing(bot, event)

    bot.send_message.assert_called_once()
    args, kwargs = bot.send_message.call_args
    assert kwargs['text'] == 'Разговаривай без мата, дуралей!'
    assert kwargs['reply_to_message_id'] == 2
    assert kwargs['chat_id'] == -4
