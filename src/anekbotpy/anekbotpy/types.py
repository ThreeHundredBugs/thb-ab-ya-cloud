import dataclasses
from typing import Callable, Any, Awaitable

from telegram import Bot


@dataclasses.dataclass
class HandlerResult:
    pass  # for the future


Event = dict[str, Any]
Handler = Callable[[Bot, Event], Awaitable[HandlerResult]]
