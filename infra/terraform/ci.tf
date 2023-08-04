resource "yandex_iam_service_account" "anekbot_updater" {
  name        = "anekbot-updater"
  description = "SA for deploying new anekbot versions in CI/CD pipeline"
}

resource "yandex_resourcemanager_folder_iam_binding" "functions_editors" {
  folder_id = var.yandex_folder_id
  role      = "functions.editor"

  members = [
    "serviceAccount:${yandex_iam_service_account.anekbot_updater.id}",
  ]
}
