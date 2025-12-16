locals {
  container_name = var.app_name
  log_group_name = "/ecs/${var.app_name}"
}