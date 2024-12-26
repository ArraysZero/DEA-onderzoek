# include .env

ifndef DOCKER_COMPOSE_COMMAND
override DOCKER_COMPOSE_COMMAND = docker-compose
endif

build:
	@echo "Building API"
	@${DOCKER_COMPOSE_COMMAND} build

start:
	@echo "Starting API"
	@${DOCKER_COMPOSE_COMMAND} -f docker-compose.yml up -d
	@${DOCKER_COMPOSE_COMMAND} logs -f server

stop:
	@echo "Stopping API"
	@${DOCKER_COMPOSE_COMMAND} down

clean: 
	@read -p "You are about to stop the containers and delete the contents of the database but not the tables. Continue? (y/n): " yn; \
	case "$$yn" in \
		y|Y ) ${DOCKER_COMPOSE_COMMAND} -f docker-compose.yml down; rm -rf ./databases/auth-db/db-data/*; echo "All cleaned, happy code" ;; \
		* ) echo "Aborted" ;; \
	esac

# tdd-auth-server:
# 	@echo "Running tdd for auth-server"
# 	@${DOCKER_COMPOSE_COMMAND} -f docker-compose.yml -f docker-compose.tdd.yml up auth-server

# unit-auth-server:
# 	@echo "Running unit tests for auth-server"
# 	@${DOCKER_COMPOSE_COMMAND} -f docker-compose.yml -f docker-compose.unit.yml up auth-server