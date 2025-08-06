provider "aws" {
	region = "ap-northeast-2"
}

resource "aws_instance" "web" {
	ami = "ami-0d6889d14c69512e9"
	instance_type = "t2.micro"
	tags = {
		Name = "Terraform-Web-minji"
	}
}

