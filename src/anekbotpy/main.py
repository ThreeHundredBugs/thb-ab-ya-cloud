import enum
import os
import random
import json
import httpx
from telegram import Bot

_BOT_TOKEN = os.environ['BOT_TOKEN']
_BOT = None


async def main(event: dict, context):
    tg_event = json.loads(event['body'])
    print(tg_event)

    msg: dict = tg_event.get('message', {})
    text: str = msg.get('text')

    if text is None:
        return {'statusCode': 200}

    if 'анек!' in text.lower():
        await get_bot().send_message(
            chat_id=msg['chat']['id'],
            text=get_anek(),
            reply_to_message_id=msg['message_id'],
        )

    return {'statusCode': 200}


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


def get_bot() -> Bot:
    global _BOT
    if _BOT is None:
        _BOT = Bot(token=_BOT_TOKEN)
    return _BOT
