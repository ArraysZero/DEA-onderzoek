"use strict";
const Fastify = require("fastify");
const path = require("node:path");
const AutoLoad = require("@fastify/autoload");
const routes = require("./routes/index");

const server = Fastify({
  logger: true,
});

// routes.forEach((route) => {
//   server.route(route);
// });

// Declare a route
server.get("/", function (request, reply) {
  console.log(routes);
  reply.send({ hello: "world" });
});

// Run the server!
server.listen({ port: 3000 }, function (err, address) {
  if (err) {
    fastify.log.error(err);
    process.exit(1);
  }
  // Server is now listening on ${address}
});
