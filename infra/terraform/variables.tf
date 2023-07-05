variable "yandex_token" {
  type        = string
  description = "IAM token to for Yandex Cloud. See https://cloud.yandex.com/en/docs/iam/operations/iam-token/create"
}

variable "yandex_cloud_id" {
  type = string
}

variable "yandex_folder_id" {
  type = string
}

variable "tg_bot_token" {
  type        = string
  description = "Telegram bot token"
}

variable "tg_bot_webhook_path" {
  type        = string
  description = "Path for Telegram to send events to"
}
