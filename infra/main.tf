module "ecs" {
  source = "./ecs"

  app_name        = "baitersburger-customer-app"
  container_port  = 8080
  role_name       = "LabRole"
  db_secret_name  = "aws-rds-credentials"
  image_uri = var.image_uri
}