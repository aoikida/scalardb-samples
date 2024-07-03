export class Post {
  id: number;
  userName: string;
  content: string;
  serverName: string;

  constructor(
    id: number,
    userName: string,
    content: string,
    serverName: string
  ) {
    this.id = id;
    this.userName = userName;
    this.content = content;
    this.serverName = serverName;
  }
}
