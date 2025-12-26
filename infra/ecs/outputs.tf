output "ecs_cluster_name" {
  value = aws_ecs_cluster.this.name
}

output "ecs_service_name" {
  value = aws_ecs_service.this.name
}

output "vpc_link_id" {
  value = aws_api_gateway_vpc_link.this.id
}

output "nlb_dns_name" {
  value = aws_lb.this.dns_name
}