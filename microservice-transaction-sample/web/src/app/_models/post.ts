export class Post {
  id: number;
  userName: string;
  message: string;
  serverId: number;

  constructor(id: number, userName: string, message: string, serverId: number) {
    this.id = id;
    this.userName = userName;
    this.message = message;
    this.serverId = serverId;
  }
}
