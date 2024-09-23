import json
import os

from telegram import Bot

from anekbotpy import handle_event

_BOT_TOKEN = os.environ['BOT_TOKEN']


async def main(event: dict, context):
    tg_event = json.loads(event['body'])
    print(json.dumps(tg_event))

    bot = Bot(token=_BOT_TOKEN)
    await handle_event(bot, tg_event)

    return {'statusCode': 200}
