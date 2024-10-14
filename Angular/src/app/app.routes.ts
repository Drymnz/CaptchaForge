import { Routes } from '@angular/router';
import CaptchaGeneratorComponent from './components/captcha-generator/captcha-generator.component';
import { CaptchaUsageReportComponent } from './components/captcha-usage-report/captcha-usage-report.component';
import { SymbolTableComponent } from './components/symbol-table/symbol-table.component';

export const routes: Routes = [
    {
        path: 'generar',
        title:'Generador de Captcha',
        component:CaptchaGeneratorComponent
    },
    {
        path: 'reporte-captcha',
        title:'Reportes de captcha utilizados',
        component:CaptchaUsageReportComponent
    },
    {
        path: 'tabla-simbolos',
        title:'Tabla de simbolos',
        component:SymbolTableComponent
    },
    {
        path: 'list-chaptcha',
        title:'Listado de Captcha',
        component:SymbolTableComponent
    },
    {
        path: '**',
        redirectTo:'generar',
        pathMatch: 'full'
    },
    {
        path: '',
        redirectTo:'generar',
        pathMatch: 'full'
    }
];
