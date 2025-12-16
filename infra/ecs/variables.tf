variable "app_name" {
  type = string
}

variable "container_port" {
  type = number
}

variable "role_name" {
  type        = string
  description = "Role existente no AWS Academy"
}

variable "db_secret_name" {
  type = string
}

variable "aws_region" {
  type    = string
  default = "us-east-1"
}

variable "image_uri" {
  type = string
}