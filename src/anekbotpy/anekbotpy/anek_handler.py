import enum
import random

import httpx
from telegram import Bot

from .types import Event, Handler, HandlerResult


async def handle_anek(bot: Bot, event: Event) -> HandlerResult:
    msg: dict = event.get('message', {})
    text: str = msg.get('text')

    if text is None:
        return HandlerResult()

    if 'анек!' in text.lower():
        await bot.send_message(
            chat_id=msg['chat']['id'],
            text=get_anek(),
            reply_to_message_id=msg['message_id'],
        )

    return HandlerResult()


_handler: Handler = handle_anek


# http://rzhunemogu.ru/FAQ.aspx
class AnekType(enum.Enum):
    ANEK = 1
    ANEK18 = 11


def get_anek() -> str:
    anek_type = get_anek_type()
    resp = httpx.get(f'http://rzhunemogu.ru/RandJSON.aspx?CType={anek_type.value}')
    return resp.text.removeprefix('{"content":"').removesuffix('"}')


def get_anek_type() -> AnekType:
    rand = random.random()
    if rand > 0.85:
        return AnekType.ANEK18
    return AnekType.ANEK
