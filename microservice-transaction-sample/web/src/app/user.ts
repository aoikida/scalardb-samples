class User {
    id: number;
    name: string;
    email: string;
    password: string;
    role: string;
    created_at: string;
    updated_at: string;
    token: string;
    constructor() {
        this.id = 0;
        this.name = '';
        this.email = '';
        this.password = '';
        this.role = '';
        this.created_at = '';
        this.updated_at = '';
        this.token = '';
    }
}
