variable "image_uri" {
  description = "URI da imagem Docker no ECR"
  type        = string
}

variable "db_host" {
  description = "Endpoint do banco de dados recuperado via GitHub Secrets"
  type        = string
}