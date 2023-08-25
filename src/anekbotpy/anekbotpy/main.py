import asyncio

from telegram import Bot

from .anek_handler import handle_anek
from .swearing_handler import handle_swearing
from .types import Handler, Event, HandlerResult


async def handle_event(bot: Bot, event: Event) -> HandlerResult:
    handlers: list[Handler] = [
        handle_anek,
        handle_swearing,
    ]

    await asyncio.gather(*[handle(bot, event) for handle in handlers])

    return HandlerResult()


# this is for type hints
__handler: Handler = handle_event
