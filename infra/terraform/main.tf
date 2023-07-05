resource "telegram_bot_webhook" "anekbot" {
  url = "${yandex_api_gateway.telegram_webhooks.domain}/${var.tg_bot_webhook_path}"
}

resource "yandex_api_gateway" "telegram_webhooks" {
  name        = "telegram-webhooks"
  description = "API gateway for Telegram Webhooks"

  connectivity {
    network_id = data.yandex_vpc_network.default.id
  }

  spec = jsonencode({
    openapi : "3.0.0"
    info : {
      title : "Telegram Webhook"
      version : "1.0.0"
    },
    paths : {
      "/${var.tg_bot_webhook_path}" : {
        "post" : {
          "x-yc-apigateway-integration" : {
            type : "cloud_functions"
            function_id : data.yandex_function.anekbot.id
            tag : "$latest"
            service_account_id : yandex_iam_service_account.anekbot_invoker.id
          }
        }
      }
      "/echo" : {
        "get" : {
          "x-yc-apigateway-integration" : {
            type : "cloud_functions"
            function_id : data.yandex_function.anekbot.id
            tag : "$latest"
            service_account_id : yandex_iam_service_account.anekbot_invoker.id
          }
        }
      }
    }
  })
}

data "yandex_vpc_network" "default" {
  network_id = "enppudqnjkiecsjplrhm"
}

data "yandex_function" "anekbot" {
  function_id = "d4el6cch94mopqqmkveh"
}

resource "yandex_iam_service_account" "anekbot_invoker" {
  name        = "anekbot-invoker"
  description = "anekbot service account"
}

resource "yandex_function_iam_binding" "anekbot" {
  function_id = data.yandex_function.anekbot.id
  role        = "serverless.functions.invoker"
  members = [
    "serviceAccount:${yandex_iam_service_account.anekbot_invoker.id}",
  ]
}
