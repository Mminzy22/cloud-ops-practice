variable "ami_id" {
  description = "EC2 AMI ID"
  type        = string
}

variable "instance_type" {
  description = "EC2 instance_type"
  type        = string
  default     = "t2.micro"
}

variable "key_name" {
  description = "EC2 인스턴스에 사용할 키페어 이름"
  type        = string
}
