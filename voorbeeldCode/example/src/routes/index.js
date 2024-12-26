const loginHandler = require("./login");

module.exports = async (fastify, opts) => {
  // console.log("routes")
  fastify.route({
    method: GET,
    URL: "/login",
    // schema: ,
    handler: loginHandler,
  });
};
