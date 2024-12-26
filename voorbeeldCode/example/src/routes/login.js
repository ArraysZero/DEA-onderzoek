module.exports = async function login(req, reply) {
  //   const user = await this.users.getUserByEmail(req.body.email);

  //   if (
  //     !user ||
  //     !(await this.auth.checkPassword(req.body.password, user.password))
  //   ) {
  //     reply.code(401);
  //     return {
  //       message: "username or password incorrect",
  //     };
  //   }

  //   if (user.email_confirmed === false) {
  //     reply.code(401);
  //     return {
  //       message: "please confirm email",
  //     };
  //   }

  //   const responseRoles = await this.users.getUserRoles(user.id);

  //   const roles = responseRoles?.map((role) => role.name);

  //   const access_token = this.tokenUtils.generateAccessToken({ ...user, roles });
  //   const refresh_token = await this.tokenUtils.generateRefreshToken(user.id);

  //   return {
  //     access_token: access_token,
  //     refresh_token: refresh_token,
  //   };

  return true;
};

// module.exports = login;
