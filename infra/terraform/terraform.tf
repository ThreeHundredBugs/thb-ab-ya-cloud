provider "yandex" {
  token     = var.yandex_token
  cloud_id  = "thb-cloud"
  folder_id = "b1gn7p2gkekjho015chm"
  zone      = "ru-central1-a"
}

provider "telegram" {
  bot_token = var.tg_bot_token
}

terraform {
  required_providers {
    yandex = {
      source  = "yandex-cloud/yandex"
      version = ">= 0.93"
    }
    telegram = {
      source  = "yi-jiayu/telegram"
      version = ">= 0.3.1"
    }
  }
}
