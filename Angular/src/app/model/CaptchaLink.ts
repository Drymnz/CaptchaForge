
export class CaptchaLink {
    private id: string;
    private link: string;

    constructor( id: string, link: string) {
        this.id = id;
        this.link = link;
    }

    public getId(): string {
        return this.id;
    }

    public getLink(): string {
        return this.link;
    }
}
