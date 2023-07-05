import os
import json
import httpx
from telegram import Bot

_BOT_TOKEN = os.environ['BOT_TOKEN']
_BOT = None


async def main(event: dict, context):
    tg_event = json.loads(event['body'])
    print(tg_event)

    if (msg := tg_event.get('message')) is None:
        return {'statusCode': 200}

    text: str = msg['text']

    if 'анек!' in text.lower():
        await get_bot().send_message(
            chat_id=msg['chat']['id'],
            text=get_anek(),
            reply_to_message_id=msg['message_id'],
        )

    return {'statusCode': 200}


def get_anek() -> str:
    resp = httpx.get('http://rzhunemogu.ru/RandJSON.aspx?CType=11')
    return resp.text.removeprefix('{"content":"').removesuffix('"}')


def get_bot() -> Bot:
    global _BOT
    if _BOT is None:
        _BOT = Bot(token=_BOT_TOKEN)
    return _BOT
