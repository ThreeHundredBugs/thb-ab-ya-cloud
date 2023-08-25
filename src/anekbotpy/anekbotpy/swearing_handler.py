import re

from telegram import Bot

from .types import Event, Handler, HandlerResult


async def handle_swearing(bot: Bot, event: Event) -> HandlerResult:
    msg: dict = event.get('message', {})
    text: str = msg.get('text')

    if text is None:
        return HandlerResult()

    words = split_sentence(text.lower())
    if set(words) & SWEARINGS:
        await bot.send_photo(
            chat_id=msg['chat']['id'],
            photo='AgACAgIAAx0EaRYESgACgh1k6K7-pPxwMEjNDMWN87dMr39BugACRc8xG-RBQEt8cnLt71tN5AEAAwIAA3gAAzAE',
            reply_to_message_id=msg['message_id'],
        )

    return HandlerResult()


_handler: Handler = handle_swearing


def split_sentence(sentence: str) -> list[str]:
    return re.findall(r'\b\w+\b', sentence)


SWEARINGS = {
    "6ля",
    "6лядь",
    "6лять",
    "b3ъeб",
    "cock",
    "cunt",
    "e6aль",
    "ebal",
    "eblan",
    "eбaл",
    "eбaть",
    "eбyч",
    "eбать",
    "eбёт",
    "eблантий",
    "xyёв",
    "xyй",
    "xyя",
    "xуе",
    "xую",
    "zaeb",
    "zaebal",
    "zaebali",
    "zaebat",
    "архипиздрит",
    "ахуел",
    "ахуела",
    "ахуенно",
    "ахуеть",
    "бля",
    "бляд",
    "бляди",
    "блядина",
    "блядище",
    "блядки",
    "блядовать",
    "блядство",
    "блядун",
    "блядуны",
    "блядунья",
    "блядь",
    "блядюга",
    "блять",
    "взъебка",
    "взьебка",
    "взьебывать",
    "въеб",
    "въебался",
    "въебусь",
    "въебывать",
    "выблядок",
    "выблядыш",
    "выеб",
    "выебать",
    "выебен",
    "выебнулся",
    "выебон",
    "выебываться",
    "вьебен",
    "гондон",
    "доебываться",
    "долбоеб",
    "долбоёб",
    "е6ал",
    "е6ут",
    "ёбaн",
    "ебaть",
    "ебyч",
    "ебал",
    "ебало",
    "ебальник",
    "ебан",
    "ебанамать",
    "ебанат",
    "ебаная",
    "ёбаная",
    "ебанический",
    "ебанный",
    "ебанныйврот",
    "ебаное",
    "ебануть",
    "ебануться",
    "ёбаную",
    "ебаный",
    "ебанько",
    "ебарь",
    "ебат",
    "ёбат",
    "ебатория",
    "ебать",
    "ебать-копать",
    "ебаться",
    "ебашить",
    "ебёна",
    "ебет",
    "ебёт",
    "ебец",
    "ебик",
    "ебин",
    "ебись",
    "ебическая",
    "ебки",
    "ебла",
    "еблан",
    "ебланам",
    "еблану",
    "ебланы",
    "ебливый",
    "еблище",
    "ебло",
    "еблыст",
    "ебля",
    "ёбн",
    "ёбнул",
    "ёбнулся",
    "ебнуть",
    "ебнуться",
    "ебня",
    "ебошить",
    "ебская",
    "ебский",
    "ебтвоюмать",
    "ебун",
    "ебут",
    "ебуч",
    "ебуче",
    "ебучее",
    "ебучий",
    "ебучим",
    "ебущ",
    "ебырь",
    "елда",
    "елдак",
    "зае6",
    "заё6",
    "заеб",
    "заёб",
    "заеба",
    "заебал",
    "заебанец",
    "заебастая",
    "заебастый",
    "заебать",
    "заебаться",
    "заебашить",
    "заебистое",
    "заёбистое",
    "заебистые",
    "заёбистые",
    "заебистый",
    "заёбистый",
    "заебись",
    "заебошить",
    "заебываться",
    "залуп",
    "залупа",
    "залупаться",
    "залупить",
    "залупиться",
    "замудохаться",
    "запиздячить",
    "захуячить",
    "заябестая",
    "злоеб",
    "злоебучая",
    "злоебучее",
    "злоебучий",
    "ибанамат",
    "ибонех",
    "изъебнуться",
    "ипать",
    "ипаться",
    "ипаццо",
    "манда",
    "мандавошек",
    "мандавошка",
    "мандавошки",
    "мандища",
    "мандой",
    "манду",
    "млять",
    "мудоеб",
    "наебать",
    "наебет",
    "наебнуть",
    "наебнуться",
    "наебывать",
    "напиздел",
    "напиздели",
    "напиздело",
    "напиздили",
    "настопиздить",
    "нахуй",
    "нахуя",
    "нахуйник",
    "невротебучий",
    "невъебенно",
    "Нехуй",
    "нехуйственно",
    "ниибацо",
    "ниипацца",
    "ниипаццо",
    "ниипет",
    "никуя",
    "нихера",
    "нихуя",
    "объебос",
    "обьебать",
    "однохуйственно",
    "опездал",
    "опизде",
    "опизденивающе",
    "остоебенить",
    "остопиздеть",
    "отмудохать",
    "отпиздить",
    "отпиздячить",
    "отъебись",
    "охуевательский",
    "охуевать",
    "охуевающий",
    "охуел",
    "охуенно",
    "охуеньчик",
    "охуеть",
    "охуительно",
    "охуительный",
    "охуяньчик",
    "охуячивать",
    "охуячить",
    "педерас",
    "педик",
    "педрик",
    "педрила",
    "педрилло",
    "педрило",
    "педрилы",
    "пездень",
    "пездит",
    "пездишь",
    "пездо",
    "пездят",
    "переёбок",
    "пи3д",
    "пи3де",
    "пи3ду",
    "пиzдец",
    "пидар",
    "пидарaс",
    "пидарас",
    "пидарасы",
    "пидары",
    "пидор",
    "пидорасы",
    "пидорка",
    "пидорок",
    "пидоры",
    "пидрас",
    "пизда",
    "пиздануть",
    "пиздануться",
    "пиздарваньчик",
    "пиздато",
    "пиздатое",
    "пиздатый",
    "пизденка",
    "пизденыш",
    "пиздёныш",
    "пиздеть",
    "пиздец",
    "пиздили",
    "пиздит",
    "пиздить",
    "пиздиться",
    "пиздишь",
    "пиздища",
    "пиздище",
    "пиздобол",
    "пиздоболы",
    "пиздобратия",
    "пиздоватая",
    "пиздоватый",
    "пиздолиз",
    "пиздонутые",
    "пиздорванец",
    "пиздорванка",
    "пиздострадатель",
    "пизду",
    "пиздуй",
    "пиздун",
    "пиздунья",
    "пизды",
    "пиздюга",
    "пиздюк",
    "пиздюлина",
    "пиздюля",
    "пиздят",
    "пиздячить",
    "поебать",
    "поебень",
    "поёбываает",
    "похуист",
    "похуистка",
    "похуй",
    "похую",
    "придурок",
    "приебаться",
    "припиздень",
    "припизднутый",
    "припиздюлина",
    "проблядь",
    "проеб",
    "проебанка",
    "проебать",
    "пропизделся",
    "пропиздеть",
    "пропиздячить",
    "разхуячить",
    "разъеб",
    "разъеба",
    "разъебай",
    "разъебать",
    "распиздай",
    "распиздеться",
    "распиздяй",
    "распиздяйство",
    "распроеть",
    "спиздел",
    "спиздеть",
    "спиздил",
    "спиздила",
    "спиздили",
    "спиздит",
    "спиздить",
    "страхопиздище",
    "суходрочка",
    "съебаться",
    "трахае6",
    "трахаёб",
    "уебать",
    "уёбища",
    "уебище",
    "уёбище",
    "уебищное",
    "уёбищное",
    "уебк",
    "уебки",
    "уёбки",
    "уебок",
    "уёбок",
    "хyё",
    "хyй",
    "хyйня",
    "хамло",
    "хитровыебанный",
    "хуeм",
    "хуе",
    "хуё",
    "хуев",
    "хуевато",
    "хуёвенький",
    "хуевина",
    "хуево",
    "хуевый",
    "хуёвый",
    "хуек",
    "хуёк",
    "хуел",
    "хуем",
    "хуенч",
    "хуеныш",
    "хуенький",
    "хуеплет",
    "хуеплёт",
    "хуепромышленник",
    "хуерик",
    "хуерыло",
    "хуесос",
    "хуесоска",
    "хуета",
    "хуетень",
    "хуею",
    "хуи",
    "хуище",
    "хуй",
    "хуйком",
    "хуйло",
    "хуйня",
    "хуйрик",
    "хуля",
    "хую",
    "хуюл",
    "хуя",
    "хуяк",
    "хуякать",
    "хуякнуть",
    "хуям",
    "х_у_я_р_а",
    "хуяра",
    "хуясе",
    "хуячить",
}
