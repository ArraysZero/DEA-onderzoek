# Use a node image from Docker Hub
FROM node:21.7.3-alpine3.19

# Set the working directory in the container to /usr/src/app
WORKDIR /usr/src/app

# Install the fastify-cli globally in the container
RUN npm install -g fastify-cli

# Add the code to the container
ADD src ./src
# ADD package.json .

# Install the npm dependencies specified in package.json
RUN npm install

# Set the command to be run when the container starts
ENTRYPOINT [ "npm", "start" ]